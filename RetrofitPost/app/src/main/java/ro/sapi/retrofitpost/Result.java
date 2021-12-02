package ro.sapi.retrofitpost;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class Result {

    @SerializedName("token")
    @Expose
    private String token;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    @Override
    public String toString() {
        return "Result{" +
                "token='" + token + '\'' +
                '}';
    }
}
