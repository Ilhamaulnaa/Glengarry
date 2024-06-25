package com.data.event.data.paging

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.common.toArrayParamFormat
import com.core.domain.model.ServiceItem
import com.core.domain.model.ServiceType
import com.data.event.data.remote.service.GlengarryService
import com.haroldadmin.cnradapter.NetworkResponse
import com.data.event.data.mapper.toDomains

class ServicePagingSource (
    private val service: GlengarryService,
    private val name: String = "",
    private val serviceType: String = "",
    private val field: List<String> = emptyList(),
    private val type: ServiceType,
    private val fees: String = "",
    private val location: List<String> = emptyList(),
) : PagingSource<Int, ServiceItem>() {

    companion object {
        const val DEFAULT_PAGE = 0
        const val DEFAULT_SIZE = 30
    }

    override fun getRefreshKey(state: PagingState<Int, ServiceItem>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            val anchorPage = state.closestPageToPosition(anchorPosition)
            anchorPage?.prevKey?.plus(1) ?: anchorPage?.nextKey?.minus(1)
        }
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, ServiceItem> {
        return try {
            val page = params.key ?: DEFAULT_PAGE
            val size = params.loadSize
            val response = when (type) {
                ServiceType.ALL -> service.getAllService(
                    name = name,
                    serviceType = serviceType.lowercase(),
                    limit = size,
                    page = page,
                    field = field.toArrayParamFormat(),
                    location = location.toArrayParamFormat(),
                    fees = fees.lowercase()
                )

                ServiceType.FASHION -> service.getFashion(
                    name = name,
                    limit = size,
                    page = page,
                    fees = fees.lowercase(),
                    field = field.toArrayParamFormat()
                )

                ServiceType.ELECTRONIC -> service.getElectronic(
                    name = name,
                    limit = size,
                    page = page,
                    field = field.toArrayParamFormat()
                )

                ServiceType.BOOK -> service.getBook(
                    name = name,
                    limit = size,
                    page = page,
                    location = location.toArrayParamFormat(),
                    field = field.toArrayParamFormat()
                )

                ServiceType.SPORT -> service.getSport(
                    name = name,
                    limit = size,
                    page = page,
                    location = location.toArrayParamFormat(),
                    field = field.toArrayParamFormat()
                )
            }
            when (response) {
                is NetworkResponse.Success -> {
                    val data = response.body.data?.data?.toDomains(type) ?: emptyList()
                    val nextKey = if (data.isEmpty()) null else page + 1
                    val prevKey = if (page == DEFAULT_PAGE) null else page - 1
                    LoadResult.Page(
                        data = data,
                        prevKey = prevKey,
                        nextKey = nextKey
                    )
                }

                is NetworkResponse.Error -> {
                    val message = response.body?.message ?: response.error?.message
                    LoadResult.Error(
                        throwable = Throwable(message)
                    )
                }
            }
        } catch (e: Exception) {
            LoadResult.Error(e)
        }
    }

//    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, ServiceItem> {
//        return try {
//            val page = params.key ?: DEFAULT_PAGE
//            val size = params.loadSize
//            val response = when (type) {
//                ServiceType.ALL -> service.getAllService(
//                    name = name,
//                    serviceType = serviceType.lowercase(),
//                    limit = size,
//                    page = page,
//                    field = field.toArrayParamFormat(),
//                    location = location.toArrayParamFormat(),
//                    fees = fees.lowercase()
//                )
//                ServiceType.FASHION -> service.getFashion(
//                    name = name,
//                    limit = size,
//                    page = page,
//                    fees = fees.lowercase(),
//                    location = location.toArrayParamFormat(),
//                    field = field.toArrayParamFormat()
//                )
//                ServiceType.ELECTRONIC -> service.getElectronic(
//                    name = name,
//                    limit = size,
//                    page = page,
//                    location = location.toArrayParamFormat(),
//                    field = field.toArrayParamFormat()
//                )
//                ServiceType.BOOK -> service.getBook(
//                    name = name,
//                    limit = size,
//                    page = page,
//                    location = location.toArrayParamFormat(),
//                    field = field.toArrayParamFormat()
//                )
//                ServiceType.SPORT -> service.getSport(
//                    name = name,
//                    limit = size,
//                    page = page,
//                    location = location.toArrayParamFormat(),
//                    field = field.toArrayParamFormat()
//                )
//            }
//            when (response) {
//                is NetworkResponse.Success -> {
//                    val data = response.body.data?.data?.toDomains(type) ?: emptyList()
//                    val nextKey = if (data.isEmpty()) null else page + 1
//                    val prevKey = if (page == DEFAULT_PAGE) null else page - 1
//                    LoadResult.Page(
//                        data = data,
//                        prevKey = prevKey,
//                        nextKey = nextKey
//                    )
//                }
//                is NetworkResponse.Error -> {
//                    val message = response.body?.message ?: response.error?.message
//                    LoadResult.Error(
//                        throwable = Throwable(message)
//                    )
//                }
//            }
//        } catch (e: Exception) {
//            LoadResult.Error(e)
//        }
//    }

}