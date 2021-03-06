package controller;

import domain.lotto.Lotto;
import domain.lotto.LottoPurchaseQuantity;
import domain.lotto.LottoWinningNumbers;
import domain.lotto.Lottos;
import domain.lotto.Money;
import service.LottoWinningNumbersFactory;

import java.util.List;

import static view.InputView.*;
import static view.OutputView.*;

public class App {
    public static void main(String[] argc) {
        final Money amountOfMoney = inputAmountOfMoney();
        final LottoPurchaseQuantity purchaseQuantity = inputQuantityOfManualPicks(amountOfMoney);
        final List<Lotto> manualLottos = inputManualLottoNumbers(purchaseQuantity);
        printPurchaseQuantity(purchaseQuantity);
        final Lottos lottos = new Lottos(manualLottos, purchaseQuantity);
        printLottos(lottos);
        final LottoWinningNumbers winningNumbers = LottoWinningNumbersFactory.ofRecent();
        printWinningNumbers(winningNumbers);
        printResult(lottos, winningNumbers);
    }
}