//
//  Copyright (c) 2020-present antgroup.com, https://www.antgroup.com
//
//  Licensed under the Apache License, Version 2.0 (the "License");
//  you may not use this file except in compliance with the License.
//  You may obtain a copy of the License at
//
//  http://www.apache.org/licenses/LICENSE-2.0
//
//  Unless required by applicable law or agreed to in writing, software
//  distributed under the License is distributed on an "AS IS" BASIS,
//  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
//  See the License for the specific language governing permissions and
//  limitations under the License.
//
//
package cn.com.antcloud.api.mq.v2_0_0.model;

import java.lang.String;
import javax.validation.constraints.NotNull;

/**
 * 列值详情 */
public class ColumnValue {
  @NotNull
  private String name;

  @NotNull
  private String value;

  /**
   * 名称 */
  public String getName() {
    return this.name;
  }

  /**
   * 名称 */
  public void setName(String name) {
    this.name = name;
  }

  /**
   * 值 */
  public String getValue() {
    return this.value;
  }

  /**
   * 值 */
  public void setValue(String value) {
    this.value = value;
  }
}
