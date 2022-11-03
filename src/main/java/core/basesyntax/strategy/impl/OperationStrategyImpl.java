package core.basesyntax.strategy.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.OperationHandler;
import core.basesyntax.strategy.OperationStrategy;
import java.util.Map;

public class OperationStrategyImpl implements OperationStrategy {
    private Map<FruitTransaction.Operation, OperationHandler> strategies;

    @Override
    public OperationHandler getOperationType(String key) {
        return strategies.get(FruitTransaction.findOperation(key));
    }

    @Override
    public void operationTypeList(Map<FruitTransaction.Operation, OperationHandler> strategies) {
        this.strategies = strategies;
    }
}
