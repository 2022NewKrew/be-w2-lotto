package com.kakaocorp.lotto.ui.controller;

import com.kakaocorp.lotto.model.LottoTicket;
import com.kakaocorp.lotto.ui.view.BaseLottoView;
import com.kakaocorp.lotto.validation.*;

import java.util.List;
import java.util.Set;
import java.util.function.Supplier;

public abstract class LottoControllerPart<T extends BaseLottoView> {

    protected final T view;

    public LottoControllerPart(T view) {
        this.view = view;
    }

    protected <U> U getValidValue(Supplier<U> supplier) {
        try {
            return supplier.get();
        } catch (LessThanMinimumException e) {
            view.printLessThanMinimum(e.getMinimum());
        } catch (GreaterThanMaximumException e) {
            view.printGreaterThanMaximum(e.getMaximum());
        } catch (DuplicateNotAllowedException e) {
            view.printDuplicateNotAllowed();
        } catch (ValueNotAllowedException e) {
            view.printValueNotAllowed(e.getValue());
        } catch (NumberFormatException e) {
            view.printNumberFormatError();
        } catch (WrongSizeException e) {
            view.printWrongSize(e.getExpectedSize());
        }
        return getValidValue(supplier);
    }

    protected List<Integer> getValidNumbers(Supplier<List<Integer>> supplier) {
        return getValidValue(() -> getNumbers(supplier));
    }

    private List<Integer> getNumbers(Supplier<List<Integer>> supplier) {
        int min = LottoTicket.MIN_NUMBER;
        int max = LottoTicket.MAX_NUMBER;
        int count = LottoTicket.NUMBER_COUNT;
        IntCollectionValidator validator = new IntCollectionValidator(count, min, max);
        List<Integer> numbers = supplier.get();
        validator.validate(numbers);
        if (Set.copyOf(numbers).size() != numbers.size()) {
            throw new DuplicateNotAllowedException();
        }
        return numbers;
    }
}
