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

import com.example.testng.AbstractTestNGClass;
import com.example.testng.AnnotatedAtClassLevel;
import com.example.testng.AnnotatedAtMethodLevel;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.pitest.testapi.NullExecutionListener;
import org.pitest.testapi.TestGroupConfig;
import org.pitest.testapi.TestUnit;

import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestNGTestUnitFinderTest {

  private TestNGTestUnitFinder testee;

  @BeforeEach
  public void setUp() {
    final TestGroupConfig config = new TestGroupConfig(
        Collections.<String> emptyList(), Collections.<String> emptyList());
    this.testee = new TestNGTestUnitFinder(config, Collections.<String> emptyList());
  }

  @Test
  public void shouldFindSingleTestUnitForAllPublicMethodsInAnnotatedClass() {
    assertThat(findTestsFor(AnnotatedAtClassLevel.class)).hasSize(1);
  }

  @Test
  public void shouldFindSingleTestUnitClassWithAnnotatedMethods() {
    assertThat(findTestsFor(AnnotatedAtMethodLevel.class)).hasSize(1);
  }

  @Test
  public void shouldFindNoTestUnitsInUnannotatedClasses() {
    assertThat(findTestsFor(String.class)).isEmpty();
  }

  @Test
  public void shouldIgnoreAbstractClasses() {
    assertThat(findTestsFor(AbstractTestNGClass.class)).isEmpty();
  }

  private List<TestUnit> findTestsFor(Class<?> clazz) {
    return this.testee.findTestUnits(clazz, new NullExecutionListener());
  }

}
