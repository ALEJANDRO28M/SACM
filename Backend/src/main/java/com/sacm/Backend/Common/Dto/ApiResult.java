package com.sacm.Backend.Common.Dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
@Schema(description = "Estructura estándar de respuesta de la API")
public class ApiResult<T> {

    @Schema(description = "Indica si la operación fue exitosa",
            example = "true",
            required = true)
      private Boolean success;

    @Schema(description = "Mensaje descriptivo de la respuesta",
            example = "Operación exitosa",
            required = true,
            maxLength = 500)
      private String message;

    @Schema(description = "Datos retornados por la API (puede ser null si no hay datos)")
      private T data;

    /**
     * Static method to create a successful response with data.
     *
     * @param data    data returned by the API.
     * @param message message describing the result.
     * @return ApiResult with success=true.
     */

      public static <T> ApiResult<T> success(T data, String message){
          return new ApiResult<>(
                  true, message, data
          );
      }

    /**
     * Static method to create a successful response without data.
     *
     * @param message message describing the result.
     * @return ApiResult with success=true and data=null.
     */

      public static <T> ApiResult<T> success(String message){
          return new ApiResult<>(
                  true, message, null
          );
      }

    /**
     * Static method to create an error response with additional data.
     *
     * @param data    additional data to return when an error occurs.
     * @param message message describing the error.
     * @return ApiResult with success=false.
     */

    public static <T> ApiResult<T> error(T data, String message){
        return new ApiResult<>(
                false, message, data
        );
    }

    /**
     * Static method to create an error response.
     *
     * @param message message describing the error.
     * @return ApiResult with success=false and data=null.
     */

    public static <T> ApiResult<T> error(String message){
        return new ApiResult<>(
                false, message, null
        );
    }
}
