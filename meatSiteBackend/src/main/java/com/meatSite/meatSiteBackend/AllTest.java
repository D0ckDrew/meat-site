package com.meatSite.meatSiteBackend;

import com.meatSite.meatSiteBackend.auth.AuthTest;
import com.meatSite.meatSiteBackend.materialWarehouse.MaterialWarehouseTest;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@SpringBootTest
@RunWith(Suite.class)
@Suite.SuiteClasses({AuthTest.class, MaterialWarehouseTest.class} )
public class AllTest {
}
