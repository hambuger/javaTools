package httppost;

import java.io.IOException;
import java.nio.charset.Charset;

import org.apache.commons.lang3.StringUtils;
import org.apache.http.HttpEntity;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class HttpPostTool {

	public <S, T> CommonResponse doHttpPost(S param, String url, TypeReference<CommonResponse> ref) throws Exception {
		CommonResponse responseMessage = null;
		try {
			String responseMessageData = commonHttpPost(url, param);
			ObjectMapper objectMapper = new ObjectMapper();
			responseMessage = objectMapper.readValue(responseMessageData, ref);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return responseMessage;
	}

	private String commonHttpPost(String url, Object param) throws Exception {
		String result = null;
		CloseableHttpClient httpclient = HttpClients.createDefault();
		HttpPost httppost = new HttpPost(url);
		RequestConfig requestConfig = RequestConfig.custom().setConnectTimeout(20000).setConnectionRequestTimeout(20000)
				.setSocketTimeout(20000).build();
		httppost.setConfig(requestConfig);
		httppost.addHeader("Content-type", "application/json; charset=utf-8");
		httppost.setHeader("Accept", "application/json");
		String parameters = "";
		ObjectMapper mapper = new ObjectMapper();
		try {
			parameters = mapper.writeValueAsString(param);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		if (!StringUtils.isEmpty(parameters)) {
			httppost.setEntity(new StringEntity(parameters, Charset.forName("UTF-8")));
		}
		try {
			CloseableHttpResponse response = httpclient.execute(httppost);
			HttpEntity entity = response.getEntity();
			if (entity != null) {
				String responseMessageData = EntityUtils.toString(entity, "UTF-8");
				result = responseMessageData;
				System.out.println(responseMessageData);
			}
		} catch (Exception e) {
			throw new Exception("调用接口失败！");
		} finally {
			try {
				httpclient.close();
			} catch (IOException e) {
				throw new Exception("关闭接口失败！");
			}
		}
		return result;
	}

}
