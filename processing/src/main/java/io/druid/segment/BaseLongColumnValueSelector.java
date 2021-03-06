/*
 * Licensed to Metamarkets Group Inc. (Metamarkets) under one
 * or more contributor license agreements. See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership. Metamarkets licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

package io.druid.segment;

import io.druid.guice.annotations.PublicApi;
import io.druid.query.monomorphicprocessing.CalledFromHotLoop;
import io.druid.query.monomorphicprocessing.HotLoopCallee;

/**
 * Long value selecting polymorphic "part" of the {@link ColumnValueSelector} interface. Users of {@link
 * ColumnValueSelector#getLong()} are encouraged to reduce the parameter/field/etc. type to BaseLongColumnValueSelector
 * to make it impossible to accidently call any method other than {@link #getLong()}.
 *
 * All implementations of this interface MUST also implement {@link ColumnValueSelector}.
 */
@PublicApi
public interface BaseLongColumnValueSelector extends HotLoopCallee
{
  @CalledFromHotLoop
  long getLong();
}
