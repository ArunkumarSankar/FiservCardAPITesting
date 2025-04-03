package com.global;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.Assert;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class BaseClass {

    public static RequestSpecification requestSpecification;

    // Set the base URI and create a request object
    public static void requestObject(String baseURI) {
        RestAssured.baseURI = baseURI;
        requestSpecification = RestAssured.given();
    }

    // Add query parameter to the request
    public static void queryParameter(String parameterName, String parameterValue) {
        requestSpecification.queryParam(parameterName, parameterValue);
    }

    // Add path parameter to the request
    public static void pathParameter(String parameterName, String parameterValue) {
        requestSpecification.pathParam(parameterName, parameterValue);
    }



    // Execute the request and return the response
    public static Response responseObject(String requestType, String resource) {
        switch (requestType) {
            case "GET":
                return requestSpecification.request(Method.GET, resource);
            case "POST":
                return requestSpecification.request(Method.POST, resource);
            case "PUT":
                return requestSpecification.request(Method.PUT, resource);
            case "PATCH":
                return requestSpecification.request(Method.PATCH, resource);
            case "DELETE":
                return requestSpecification.request(Method.DELETE, resource);
            default:
                return null;
        }
    }

    // Validate the status code of the response
    public static void statusCode(Response response, int expectedStatusCode) {
        int actualStatusCode = response.getStatusCode();
        Assert.assertEquals(actualStatusCode, expectedStatusCode);
        System.out.println("Status Code is Validated: " + actualStatusCode);
    }

    // Print the response body
    public static void responseBody(Response response) {
        String asPrettyString = response.getBody().asPrettyString();
        System.out.println(asPrettyString);
    }

    // Read data from Excel file
    public static String readDataFromExcel(int rowNum, int cellNum) throws IOException {
        Workbook w = new XSSFWorkbook(new FileInputStream(new File("path_to_excel_file.xlsx")));
        return w.getSheet("sheet1").getRow(rowNum).getCell(cellNum).getStringCellValue();
    }


}
