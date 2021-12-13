package now.planit.Data.Utility;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author roed
 */
class DBManagerTest {

  @Test
  void getConnection() {
    assertNotNull(DBManager.getConnection());
  }

}