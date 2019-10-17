package qa.aspirezone.sc.chatassistant.network_utils.network_helpers;

import android.net.Uri;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.toolbox.HurlStack;

import org.apache.http.HttpResponse;
import org.apache.http.ProtocolVersion;
import org.apache.http.entity.BasicHttpEntity;
import org.apache.http.message.BasicHeader;
import org.apache.http.message.BasicHttpResponse;
import org.apache.http.message.BasicStatusLine;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;

import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import okhttp3.RequestBody;
import okhttp3.Response;



public class MultipartStack extends HurlStack {

    private static final MediaType MEDIA_TYPE_PNG = MediaType.parse("image/*");

//    @Override
//    public HttpResponse performRequest(Request<?> request, Map<String, String> additionalHeaders) throws IOException, AuthFailureError {
//        if (request instanceof AppMultipartRequest && request.getMethod() == Request.Method.POST) {
//
//            AppMultipartRequest request1 = (AppMultipartRequest) request;
//
//            OkHttpClient client = new OkHttpClient();
//            MultipartBody.Builder builder = new MultipartBody.Builder().setType(MultipartBody.FORM);
//
//            Map<String, String> params = request1.getParams();
//            for (String key : params.keySet()) {
//                builder.addFormDataPart(key, params.get(key));
//            }
//
//            Map<String, List<Uri>> files = request1.getFiles();
//
//            for (String key : files.keySet()) {
//                List<Uri> uris = files.get(key);
//
//                for(int i=0;i<uris.size();i++){
//                    Uri uri = uris.get(i);
//                    File file = new File(uri.getPath());
//                    builder.addFormDataPart(
//                            key,
//                            file.getName(),
//                            RequestBody.create(
//                                    MEDIA_TYPE_PNG,
//                                    file
//                            )
//                    );
//                }
//
//            }
//
//            RequestBody requestBody = builder.build();
//
//            okhttp3.Request.Builder okhttpRequestBuilder = new okhttp3.Request.Builder()
//                    .url(request.getUrl())
//                    .post(requestBody);
//
//            Map<String, String> requestHeaders = request.getHeaders();
//
//            for (String key : requestHeaders.keySet()) {
//                okhttpRequestBuilder.addHeader(key, requestHeaders.get(key));
//            }
//
//            okhttp3.Request okhttpRequest = okhttpRequestBuilder.build();
//
//            Response response = client.newCall(okhttpRequest).execute();
//            /*if (!response.isSuccessful()) {
//                throw new IOException("Unexpected code " + response);
//            } else {
//                ProtocolVersion protocolVersion1 = new ProtocolVersion("HTTP", 1, 1);
//
//                BasicStatusLine responseStatus = new BasicStatusLine(protocolVersion1, response.code(), response.message());
//                BasicHttpResponse basicHttpResponse = new BasicHttpResponse(responseStatus);
//
//                if (hasResponseBody(request.getMethod(), responseStatus.getStatusCode())) {
//                    BasicHttpEntity entity = new BasicHttpEntity();
//
//                    InputStream inputStream = response.body().source().inputStream();
//                    entity.setContent(inputStream);
//                    entity.setContentLength(response.body().contentLength());
//                    entity.setContentEncoding(response.header("Content-Encoding"));
//                    entity.setContentType(response.body().contentType().type());
//
//                    basicHttpResponse.setEntity(entity);
//                }
//
//                Map<String, List<String>> headers = response.headers().toMultimap();
//
//                for (Map.Entry header : headers.entrySet()) {
//                    BasicHeader h = new BasicHeader((String) header.getKey(), (String) ((List) header.getValue()).send(0));
//                    basicHttpResponse.addHeader(h);
//                }
//
//                return basicHttpResponse;
//            }*/
//            return getBasicHttpResponse(request,response);
//
//        }else if(request instanceof AppBinaryRequest && request.getMethod() == Request.Method.POST) {
//            AppBinaryRequest request1 = (AppBinaryRequest) request;
//            OkHttpClient client = new OkHttpClient();
//
//            File file = new File((request1.getUri().getPath()));
//
//            okhttp3.Request.Builder okHttpRequestBuilder = new okhttp3.Request.Builder()
//                    .url(request1.getUrl())
//                    .post(RequestBody.create(MEDIA_TYPE_PNG,file));
//
//            Map<String, String> requestHeaders = request.getHeaders();
//
//            for (String key : requestHeaders.keySet()) {
//                okHttpRequestBuilder.addHeader(key, requestHeaders.get(key));
//            }
//
//            okhttp3.Request okhttpRequest = okHttpRequestBuilder.build();
//            Response response = client.newCall(okhttpRequest).execute();
//
//            return getBasicHttpResponse(request,response);
//        }
//        else{
//            return super.performRequest(request, additionalHeaders);
//        }
//    }

    private static boolean hasResponseBody(int requestMethod, int responseCode) {
        return requestMethod != 4 && (100 > responseCode || responseCode >= 200) && responseCode != 204 && responseCode != 304;
    }

    private HttpResponse getBasicHttpResponse(Request<?> request, Response response) throws IOException {
        if (!response.isSuccessful()) {
            throw new IOException("Unexpected code " + response);
        } else {
            ProtocolVersion protocolVersion1 = new ProtocolVersion("HTTP", 1, 1);

            BasicStatusLine responseStatus = new BasicStatusLine(protocolVersion1, response.code(), response.message());
            BasicHttpResponse basicHttpResponse = new BasicHttpResponse(responseStatus);

            if (hasResponseBody(request.getMethod(), responseStatus.getStatusCode())) {
                BasicHttpEntity entity = new BasicHttpEntity();

                InputStream inputStream = response.body().source().inputStream();
                entity.setContent(inputStream);
                entity.setContentLength(response.body().contentLength());
                entity.setContentEncoding(response.header("Content-Encoding"));
                entity.setContentType(response.body().contentType().type());

                basicHttpResponse.setEntity(entity);
            }

            Map<String, List<String>> headers = response.headers().toMultimap();

            for (Map.Entry header : headers.entrySet()) {
                BasicHeader h = new BasicHeader((String) header.getKey(), (String) ((List) header.getValue()).get(0));
                basicHttpResponse.addHeader(h);
            }

            return basicHttpResponse;
        }
    }

}
