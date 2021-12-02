package ro.sapi.retrofitapp;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;



public interface GetDataService {

    @GET("/todos")
    Call<List<Todo>> getAllTodos();

}