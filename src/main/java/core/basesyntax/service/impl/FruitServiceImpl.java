package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.FruitService;
import core.basesyntax.strategy.OperationHandler;
import core.basesyntax.strategy.OperationStrategy;
import java.util.List;

public class FruitServiceImpl implements FruitService {
    private final OperationStrategy operationStrategy;

    public FruitServiceImpl(OperationStrategy operationStrategy) {
        this.operationStrategy = operationStrategy;
    }

    @Override
    public void apply(List<FruitTransaction> transactions) {
        for (FruitTransaction i : transactions) {
            OperationHandler operationHandler = operationStrategy
                    .getOperationType(i.getOperation().getOperation());
            operationHandler.valueOperation(i.getFruit(), i.getQuantity());
        }
    }
}