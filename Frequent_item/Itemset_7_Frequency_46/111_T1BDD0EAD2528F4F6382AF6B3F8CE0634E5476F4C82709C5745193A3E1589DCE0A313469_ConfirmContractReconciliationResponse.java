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
package cn.com.antcloud.api.ak_21987e3a5471407684951706d529fce5.v1_0.response;

import cn.com.antcloud.api.ak_21987e3a5471407684951706d529fce5.v1_0.model.Reconciliation;
import cn.com.antcloud.api.product.AntCloudProdResponse;

/**
 * 结算单确认 */
public class ConfirmContractReconciliationResponse extends AntCloudProdResponse {
  private Reconciliation reconciliation;

  /**
   * 结算单 */
  public Reconciliation getReconciliation() {
    return this.reconciliation;
  }

  /**
   * 结算单 */
  public void setReconciliation(Reconciliation reconciliation) {
    this.reconciliation = reconciliation;
  }
}
