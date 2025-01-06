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
package cn.com.antcloud.api.provider.ak_0cce1ca29266424ab22c6aaa22c16d70.v1_0.request;

import cn.com.antcloud.api.product.provider.AntCloudProdProviderRequest;
import cn.com.antcloud.api.provider.ak_0cce1ca29266424ab22c6aaa22c16d70.v1_0.response.ConfirmContractReconciliationResponse;
import java.lang.String;
import javax.validation.constraints.NotNull;

/**
 * 结算单确认 */
public class ConfirmContractReconciliationRequest extends AntCloudProdProviderRequest<ConfirmContractReconciliationResponse> {
  @NotNull
  private String supCode;

  @NotNull
  private String socreDate;

  @NotNull
  private String confirmType;

  @NotNull
  private String confirmer;

  @NotNull
  private String confirmStatus;

  /**
   * 服务商 */
  public String getSupCode() {
    return this.supCode;
  }

  /**
   * 服务商 */
  public void setSupCode(String supCode) {
    this.supCode = supCode;
  }

  /**
   * 确认时间 */
  public String getSocreDate() {
    return this.socreDate;
  }

  /**
   * 确认时间 */
  public void setSocreDate(String socreDate) {
    this.socreDate = socreDate;
  }

  /**
   * 确认类型：1、长城  2、服务方 */
  public String getConfirmType() {
    return this.confirmType;
  }

  /**
   * 确认类型：1、长城  2、服务方 */
  public void setConfirmType(String confirmType) {
    this.confirmType = confirmType;
  }

  /**
   * 确认者 */
  public String getConfirmer() {
    return this.confirmer;
  }

  /**
   * 确认者 */
  public void setConfirmer(String confirmer) {
    this.confirmer = confirmer;
  }

  /**
   * 认证状态 */
  public String getConfirmStatus() {
    return this.confirmStatus;
  }

  /**
   * 认证状态 */
  public void setConfirmStatus(String confirmStatus) {
    this.confirmStatus = confirmStatus;
  }
}
