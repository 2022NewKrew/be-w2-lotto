package service;

import repository.LottoRepository;

public class LottoServiceImpl implements LottoService{

    private final LottoRepository lottoRepository;

    public LottoServiceImpl(LottoRepository lottoRepository) {
        this.lottoRepository = lottoRepository;

    }
}
