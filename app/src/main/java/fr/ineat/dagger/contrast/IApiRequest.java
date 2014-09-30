package fr.ineat.dagger.contrast;

import java.util.List;

import fr.ineat.dagger.model.Contributor;
import retrofit.http.GET;
import retrofit.http.Path;

/**
 * Created by nicolasbro on 30/09/2014.
 */
public interface IApiRequest {

    public final static String API_URL_BASE = "https://api.github.com";

    public final static String API_URL_CONTRIBUTOR = "/repos/{owner}/{repo}/contributors";

    @GET(API_URL_CONTRIBUTOR)
    List<Contributor> contributors(@Path("owner") String owner,@Path("repo") String repo);
}
