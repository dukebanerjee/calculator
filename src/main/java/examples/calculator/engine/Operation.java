package examples.calculator.engine;

import java.math.BigDecimal;

public interface Operation {
    BigDecimal apply(BigDecimal lhs, BigDecimal rhs);
}
