package com.alura.LiterAlura.service;

public interface IDataConverter {

    <T> T convertData(String json, Class<T> type);
}
