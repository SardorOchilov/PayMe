package jk.uz.pdp.domain.repository;

import jk.uz.pdp.domain.exception.DataNotFoundException;
import jk.uz.pdp.domain.exception.EPAMPaymentServerException;
import jk.uz.pdp.domain.model.Wallet;

import java.util.ArrayList;
import java.util.List;

public abstract class WalletRepository implements BaseCrudRepository<Wallet,Long> {
    private final List<Wallet> walletList = new ArrayList<>();
    Long id = 0L;
    @Override
    public void create(Wallet wallet) {
        if (isExist(wallet.getOwnerId())){
            throw new EPAMPaymentServerException("There is wallet in this user");
        }
        wallet.setId(id++);
        walletList.add(wallet);
    }

    @Override
    public Wallet getById(Long ownerId) {
        for (Wallet wallet:walletList) {
         if (wallet.getOwnerId().equals(ownerId)){
             return wallet;
         }
        }
        throw new DataNotFoundException("there is not wallet in this user");
    }

    @Override
    public List<Wallet> getList() {
        return walletList;
    }

    @Override
    public Wallet update(Wallet update) {
        return null;
    }

    @Override
    public void delete(Long id) {
        for (Wallet wallet:walletList) {
            if (wallet.getId().equals(id)){
                walletList.remove(wallet);
                break;
            }
        }
    }
    private boolean isExist(Long userId){
        for (Wallet wallet:walletList) {
            if (wallet.getOwnerId().equals(userId)){
                return true;
            }
        }
        return false;
    }
}
