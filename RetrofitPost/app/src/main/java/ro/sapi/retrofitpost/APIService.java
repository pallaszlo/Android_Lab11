package ro.sapi.retrofitpost;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface APIService {

    @POST("/posts")
    @FormUrlEncoded
    Call<Post> savePost(@Field("title") String title,
                        @Field("body") String body,
                        @Field("userId") long userId);

    @POST("/posts")
    Call<Post> savePost(@Body Post post);

    @DELETE("/posts/{id}")
    Call<Post> deletePost(@Path("id") int id);

    @DELETE("api/users/{id}")
    Call<User> deleteUser(@Path("id") int id);

    @POST("/api/login")
    @FormUrlEncoded
    Call<Result> login(@Field("email") String email,
                        @Field("password") String password);

}