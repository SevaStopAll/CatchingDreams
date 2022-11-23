
import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

class NetworkUtilsTest {

	@Test
	@Timeout(value = 1, unit = TimeUnit.SECONDS)
	public void getConnectionShouldReturnFasterThanOneSecond() {
		NetworkUtils.getConnection();
		return;
	}

}
