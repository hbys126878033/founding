package org.cl.member.entity.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @Description:
 * @Author: CL
 * @Date: 2021/1/28 22:17
 * @Version: 1.0
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MemberConfirmInfoVO implements Serializable {

    // 易付宝账号
    private String paynum;
    // 法人身份证号
    private String cardnum;
}
