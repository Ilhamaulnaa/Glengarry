// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: user_preferences.proto

// Protobuf Java Version: 3.25.0
package com.data.user.data.datastore;

public interface UserPreferencesDataStoreOrBuilder extends
    // @@protoc_insertion_point(interface_extends:UserPreferencesDataStore)
    com.google.protobuf.MessageLiteOrBuilder {

  /**
   * <code>string name = 1;</code>
   * @return The name.
   */
  String getName();
  /**
   * <code>string name = 1;</code>
   * @return The bytes for name.
   */
  com.google.protobuf.ByteString
      getNameBytes();

  /**
   * <code>string email = 2;</code>
   * @return The email.
   */
  String getEmail();
  /**
   * <code>string email = 2;</code>
   * @return The bytes for email.
   */
  com.google.protobuf.ByteString
      getEmailBytes();

  /**
   * <code>string access_token = 3;</code>
   * @return The accessToken.
   */
  String getAccessToken();
  /**
   * <code>string access_token = 3;</code>
   * @return The bytes for accessToken.
   */
  com.google.protobuf.ByteString
      getAccessTokenBytes();

  /**
   * <code>string refresh_token = 4;</code>
   * @return The refreshToken.
   */
  String getRefreshToken();
  /**
   * <code>string refresh_token = 4;</code>
   * @return The bytes for refreshToken.
   */
  com.google.protobuf.ByteString
      getRefreshTokenBytes();
}
