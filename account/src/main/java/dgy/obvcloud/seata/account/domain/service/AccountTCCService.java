package dgy.obvcloud.seata.account.domain.service;

import io.seata.rm.tcc.api.BusinessActionContext;
import io.seata.rm.tcc.api.BusinessActionContextParameter;
import io.seata.rm.tcc.api.LocalTCC;
import io.seata.rm.tcc.api.TwoPhaseBusinessAction;

@LocalTCC
public interface AccountTCCService {

    /**
     * try
     * TwoPhaseBusinessAction name:try方法名称
     *
     * @param userId
     * @param money
     */
    @TwoPhaseBusinessAction(name = "deduct", commitMethod = "confirm", rollbackMethod = "cancel")
    void deduct(@BusinessActionContextParameter(paramName = "userId") String userId,
                @BusinessActionContextParameter(paramName = "money") int money);


    boolean confirm(BusinessActionContext ctx);

    boolean cancel(BusinessActionContext ctx);
}
