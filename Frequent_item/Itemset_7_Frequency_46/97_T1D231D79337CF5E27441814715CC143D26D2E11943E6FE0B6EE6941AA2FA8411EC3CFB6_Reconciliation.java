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
package cn.com.antcloud.api.ak_21987e3a5471407684951706d529fce5.v1_0.model;

import java.lang.Long;
import java.lang.String;
import javax.validation.constraints.NotNull;

/**
 * 对账单 */
public class Reconciliation {
  @NotNull
  private String supCode;

  @NotNull
  private String supName;

  @NotNull
  private Long settlementAmount;

  @NotNull
  private String confirmDateGw;

  @NotNull
  private String confirmerGw;

  @NotNull
  private String confirmStateGw;

  @NotNull
  private String confirmDateSup;

  @NotNull
  private String confirmerSup;

  @NotNull
  private String confirmStateSup;

  @NotNull
  private String socreDate;

  /**
   * 供应商 */
  public String getSupCode() {
    return this.supCode;
  }

  /**
   * 供应商 */
  public void setSupCode(String supCode) {
    this.supCode = supCode;
  }

  /**
   * 供应商名称 */
  public String getSupName() {
    return this.supName;
  }

  /**
   * 供应商名称 */
  public void setSupName(String supName) {
    this.supName = supName;
  }

  /**
   * 结算金额(单位分) */
  public Long getSettlementAmount() {
    return this.settlementAmount;
  }

  /**
   * 结算金额(单位分) */
  public void setSettlementAmount(Long settlementAmount) {
    this.settlementAmount = settlementAmount;
  }

  /**
   * 长城确认时间 */
  public String getConfirmDateGw() {
    return this.confirmDateGw;
  }

  /**
   * 长城确认时间 */
  public void setConfirmDateGw(String confirmDateGw) {
    this.confirmDateGw = confirmDateGw;
  }

  /**
   * 长城方确认人 */
  public String getConfirmerGw() {
    return this.confirmerGw;
  }

  /**
   * 长城方确认人 */
  public void setConfirmerGw(String confirmerGw) {
    this.confirmerGw = confirmerGw;
  }

  /**
   * 长城确认状态 */
  public String getConfirmStateGw() {
    return this.confirmStateGw;
  }

  /**
   * 长城确认状态 */
  public void setConfirmStateGw(String confirmStateGw) {
    this.confirmStateGw = confirmStateGw;
  }

  /**
   * 服务方确认时间 */
  public String getConfirmDateSup() {
    return this.confirmDateSup;
  }

  /**
   * 服务方确认时间 */
  public void setConfirmDateSup(String confirmDateSup) {
    this.confirmDateSup = confirmDateSup;
  }

  /**
   * 服务方确认人 */
  public String getConfirmerSup() {
    return this.confirmerSup;
  }

  /**
   * 服务方确认人 */
  public void setConfirmerSup(String confirmerSup) {
    this.confirmerSup = confirmerSup;
  }

  /**
   * 服务方确认状态 */
  public String getConfirmStateSup() {
    return this.confirmStateSup;
  }

  /**
   * 服务方确认状态 */
  public void setConfirmStateSup(String confirmStateSup) {
    this.confirmStateSup = confirmStateSup;
  }

  /**
   * 计算时间 */
  public String getSocreDate() {
    return this.socreDate;
  }

  /**
   * 计算时间 */
  public void setSocreDate(String socreDate) {
    this.socreDate = socreDate;
  }
}
