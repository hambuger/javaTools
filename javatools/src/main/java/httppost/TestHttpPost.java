package httppost;

import com.fasterxml.jackson.core.type.TypeReference;

public class TestHttpPost {

	public static void main(String[] args) {
		String url = "http://39.106.11.140:9015/ExternalService.asmx?wsdl";
		MesAccessToken requestData = new MesAccessToken();
		requestData.setAccessToken("1833e9492e5540ebada0aecaad904b9f");
		requestData.setSynTime("300");
		HttpPostTool httpPostTool = new HttpPostTool();
		TypeReference<CommonResponse> reponse = new TypeReference<CommonResponse>() {
		};
		try {
			CommonResponse response = httpPostTool.doHttpPost(requestData, url, reponse);
			System.out.print(response.getCode());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
