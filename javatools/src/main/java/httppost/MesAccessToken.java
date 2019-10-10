package httppost;

import java.util.Set;

public class MesAccessToken {

	public String accessToken;

	public String synTime;

	private Set<String> fromHospSet;

	public String getAccessToken() {
		return accessToken;
	}

	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}

	public String getSynTime() {
		return synTime;
	}

	public void setSynTime(String synTime) {
		this.synTime = synTime;
	}

	public Set<String> getFromHospSet() {
		return fromHospSet;
	}

	public void setFromHospSet(Set<String> fromHospSet) {
		this.fromHospSet = fromHospSet;
	}

}