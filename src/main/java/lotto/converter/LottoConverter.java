package lotto.converter;

import java.util.ArrayList;
import java.util.List;
import lotto.exception.Validator;
import lotto.view.OutputView;

public class LottoConverter {
    public static final int LOTTERY_NUMBERS_SIZE = 6;
    public static final int MINIMUM_LOTTERY_NUMBER = 1;
    public static final int MAXIMUM_LOTTERY_NUMBER = 45;

    private List<Long> lottoNumbers = new ArrayList<>();
    private long bonusNumber;

    public LottoConverter(List<Long> lottoNumbers) {
        validateSize(lottoNumbers);
        validateRange(lottoNumbers);
        validateDuplicate(lottoNumbers);
        System.out.println("constructor: " + lottoNumbers);
        this.lottoNumbers = lottoNumbers;
    }

    public LottoConverter(String bonusNumber) {
        this.bonusNumber = Validator.isNumeric(bonusNumber);
        Validator.isRightRange(this.bonusNumber);
    }

    public List<Long> getLottoNumbers() {
        System.out.println("getLottoNumbers: " + lottoNumbers);
        return lottoNumbers;
    }

    public long getBonusNumber() {
        return bonusNumber;
    }

    private void validateSize(List<Long> lottoNumbers) {
        try {
            System.out.println(lottoNumbers);
            Validator.isRightSize(lottoNumbers);
        } catch (IllegalArgumentException e) {
            OutputView.getInstance().printErrorMessage(e.getMessage());
            throw new IllegalArgumentException();
        }

    }

    private void validateRange(List<Long> lottoNumbers) {
        try {
            Validator.isRightRange(lottoNumbers);
        } catch (IllegalArgumentException e) {
            OutputView.getInstance().printErrorMessage(e.getMessage());
            throw new IllegalArgumentException();
        }

    }

    private void validateDuplicate(List<Long> lottoNumbers) {
        try {
            Validator.isDuplicated(lottoNumbers);
        } catch (IllegalArgumentException e) {
            OutputView.getInstance().printErrorMessage(e.getMessage());
            throw new IllegalArgumentException();
        }

    }


}
