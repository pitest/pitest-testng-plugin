package org.pitest.testng;

import org.pitest.classinfo.ClassByteArraySource;
import org.pitest.testapi.Configuration;
import org.pitest.testapi.TestGroupConfig;
import org.pitest.testapi.TestPluginFactory;

import java.util.Collection;

public class TestNGPlugin implements TestPluginFactory {

  @Override
  public String description() {
    return "TestNG plugin";
  }

  @Override
  public Configuration createTestFrameworkConfiguration(TestGroupConfig config,
      ClassByteArraySource source, Collection<String> excludedRunner, Collection<String> includedTestMethods) {
    return new TestNGConfiguration(config, includedTestMethods);
  }

  @Override
  public String name() {
    return "testng";
  }

}