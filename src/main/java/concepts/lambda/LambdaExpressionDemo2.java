package concepts.lambda;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LambdaExpressionDemo2 {

	static List<BigDecimal> prices = new ArrayList<BigDecimal>(Arrays.asList(
			new BigDecimal(10), new BigDecimal(40), new BigDecimal(50),
			new BigDecimal(9), new BigDecimal(20), new BigDecimal(100),
			new BigDecimal(8), new BigDecimal(60), new BigDecimal(50),
			new BigDecimal(5), new BigDecimal(200), new BigDecimal(10)));

	public static void main(String[] args) {

		findDiscountByDeclarativeWay();
		findDiscountByImperativeWay();

	}

	private static void findDiscountByImperativeWay() {
		prices.stream().filter(
				price -> price.compareTo(BigDecimal.valueOf(20)) > 0);
	}

	private static void findDiscountByDeclarativeWay() {

		BigDecimal totalDiscountPrice = BigDecimal.ZERO;

		for (BigDecimal price : prices) {
			if (price.compareTo(BigDecimal.valueOf(20)) > 0) {
				totalDiscountPrice = totalDiscountPrice.add((price
						.multiply(BigDecimal.valueOf(0.9))));
			}
		}

		System.out.println("Declarative Way : TotalDiscounr = "
				+ totalDiscountPrice);

	}

}
