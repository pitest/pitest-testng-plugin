/*
 * Copyright 2011 Henry Coles
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and limitations under the License.
 */
package org.pitest.testng;

import org.pitest.extension.common.NoTestSuiteFinder;
import org.pitest.help.Help;
import org.pitest.help.PitHelpError;
import org.pitest.testapi.Configuration;
import org.pitest.testapi.TestGroupConfig;
import org.pitest.testapi.TestSuiteFinder;
import org.pitest.testapi.TestUnitFinder;

import java.util.Collection;
import java.util.Optional;

public class TestNGConfiguration implements Configuration {

  private final TestGroupConfig config;
  private final Collection<String> includedTestMethods;

  public TestNGConfiguration(final TestGroupConfig config, final Collection<String> includedTestMethods) {
    this.config = config;
    this.includedTestMethods = includedTestMethods;
  }

  @Override
  public TestUnitFinder testUnitFinder() {
    return new TestNGTestUnitFinder(this.config, this.includedTestMethods);
  }

  @Override
  public TestSuiteFinder testSuiteFinder() {
    return new NoTestSuiteFinder();
  }

  @Override
  public Optional<PitHelpError> verifyEnvironment() {
    try {
      Class.forName("org.testng.annotations.Test");
    } catch (NoClassDefFoundError | ClassNotFoundException er) {
      // wrong error here, but need an update in pitest to correct
      return Optional.ofNullable(new PitHelpError(Help.NO_JUNIT));
    }

    return Optional.empty();
  }

}
