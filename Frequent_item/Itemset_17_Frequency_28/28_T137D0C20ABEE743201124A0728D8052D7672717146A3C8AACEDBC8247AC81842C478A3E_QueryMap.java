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
package cn.com.antcloud.api.ak_58d0e6ac9a1f4c75b8220234c093d952.v1_0.model;

import java.lang.String;
import java.util.List;
import javax.validation.constraints.NotNull;

/**
 * Map<String,Object> 集合 */
public class QueryMap {
  @NotNull
  private String name;

  private List<NameValuePair> value;

  /**
   * 键值 */
  public String getName() {
    return this.name;
  }

  /**
   * 键值 */
  public void setName(String name) {
    this.name = name;
  }

  /**
   * 额外用户信息 */
  public List<NameValuePair> getValue() {
    return this.value;
  }

  /**
   * 额外用户信息 */
  public void setValue(List<NameValuePair> value) {
    this.value = value;
  }
}
