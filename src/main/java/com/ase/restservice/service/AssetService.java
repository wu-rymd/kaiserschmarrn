package com.ase.restservice.service;

import com.ase.restservice.exception.ResourceNotFoundException;
import com.ase.restservice.model.Account;
import com.ase.restservice.model.Asset;
import com.ase.restservice.repository.AccountRepository;
import com.ase.restservice.repository.AssetRepository;
import com.ase.restservice.repository.StockRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
@Service
public class AssetService {
    @Autowired
    private AssetRepository assetRepository;
    @Autowired
    private StockRepository stockRepository;    // call the service instead when it's created?
    
    public List<Asset> getAssetsByAccountId(String accountId) {
        return assetRepository.findAllAssetsByAccountId(accountId);
    }
    public Float getAccountPortfolioValue(String accountId) {
        List<Asset> userAssets = this.getAssetsByAccountId(accountId);
        float total = 0f;
        for (Asset asset: userAssets) {
            // Total value of a given asset is the current share price * the # of shares the account owns
            total+= stockRepository.findById(asset.getStockId()).orElseThrow().getPrice() * asset.getNumShares();
        }
        return total;
    }
}
