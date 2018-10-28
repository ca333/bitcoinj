/*
 * Copyright 2013 Google Inc.
 * Copyright 2015 Andreas Schildbach
 * Copyright 2018 the bitcoinj-cash developers
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 * This file has been modified by the bitcoinj-cash developers for the bitcoinj-cash project.
 * The original file was from the bitcoinj project (https://github.com/bitcoinj/bitcoinj).
 */

package org.bitcoinj.params;

import org.bitcoinj.core.Sha256Hash;
import org.bitcoinj.core.Utils;

import static com.google.common.base.Preconditions.checkState;

/**
 * Parameters for the main production network on which people trade goods and services.
 */
 public class KomodoMainNetParams extends AbstractKomodoMainNetParams {
     public static final int MAINNET_MAJORITY_WINDOW = 4000;
     public static final int MAINNET_MAJORITY_REJECT_BLOCK_OUTDATED = 950;
     public static final int MAINNET_MAJORITY_ENFORCE_BLOCK_UPGRADE = 750;

     public KomodoMainNetParams() {
         super();
         interval = INTERVAL;
         targetTimespan = TARGET_TIMESPAN;
         maxTarget = Utils.decodeCompactBits(0x1d00ffffL);
         dumpedPrivateKeyHeader = 128;
         addressHeader = 0;
         p2shHeader = 5;
         acceptableAddressCodes = new int[] { addressHeader, p2shHeader };
         port = 7770;
         packetMagic = 0xf9eee48d;
         bip32HeaderPub = 0x0488B21E; //Komodo - The 4 byte header that serializes in base58 to "xpub".
         bip32HeaderPriv = 0x0488ADE4; //Komodo - The 4 byte header that serializes in base58 to "xprv"

         majorityEnforceBlockUpgrade = MAINNET_MAJORITY_ENFORCE_BLOCK_UPGRADE;
         majorityRejectBlockOutdated = MAINNET_MAJORITY_REJECT_BLOCK_OUTDATED;
         majorityWindow = MAINNET_MAJORITY_WINDOW;

         genesisBlock = createGenesis(this);
         id = ID_MAINNET;
         subsidyDecreaseBlockCount = 840000;
         spendableCoinbaseDepth = 100;
         String genesisHash = genesisBlock.getHashAsString();
         checkState(genesisHash.equals("027e3758c3a65b12aa1046462b486d0a63bfa1beae327897f56c5cfb7daaae71"),
                 genesisHash); /* Komodo Genesis */

         // This contains (at a minimum) the blocks which are not BIP30 compliant. BIP30 changed how duplicate
         // transactions are handled. Duplicated transactions could occur in the case where a coinbase had the same
         // extraNonce and the same outputs but appeared at different heights, and greatly complicated re-org handling.
         // Having these here simplifies block connection logic considerably.
         checkpoints.put(0, Sha256Hash.wrap("027e3758c3a65b12aa1046462b486d0a63bfa1beae327897f56c5cfb7daaae71")) /* updated */;
         //checkpoints.put(150000, Sha256Hash.wrap("00000000b6bc56656812a5b8dcad69d6ad4446dec23b5ec456c18641fb5381ba")) /* updated */;
         //checkpoints.put(500000, Sha256Hash.wrap("")) /* Replace with notarized block */;
         //checkpoints.put(1000000, Sha256Hash.wrap("")) /* Replace with notarized block */;

         dnsSeeds = new String[] {
                 "seeds.komodoplatform.com",    // kolo
                 "static.kolo.supernet.org", // kolo
                 "dynamic.kolo.supernet.org" // kolo
         };
     }

     private static AltcoinBlock createGenesis(NetworkParameters params) {
         AltcoinBlock genesisBlock = new AltcoinBlock(params, 4L);
         Transaction t = new Transaction(params);
         try {
             byte[] bytes = Hex.decode
                     ("04678afdb0fe5548271967f1a67130b7105cd6a828e03909a67962e0ea1f61deb649f6bc3f4cef38c4f35504e51ec112de5c384df7ba0b8d578a4c702b6bf11d5f");
             t.addInput(new TransactionInput(params, t, bytes));
             ByteArrayOutputStream scriptPubKeyBytes = new ByteArrayOutputStream();
             Script.writeBytes(scriptPubKeyBytes, Hex.decode
                     ("000d5ba7cda5d473947263bf194285317179d2b0d307119c2e7cc4bd8ac456f0774bd52b0cd9249be9d40718b6397a4c7bbd8f2b3272fed2823cd2af4bd1632200ba4bf796727d6347b225f670f292343274cc35099466f5fb5f0cd1c105121b28213d15db2ed7bdba490b4cedc69742a57b7c25af24485e523aadbb77a0144fc76f79ef73bd8530d42b9f3b9bed1c135ad1fe152923fafe98f95f76f1615e64c4abb1137f4c31b218ba2782bc15534788dda2cc08a0ee2987c8b27ff41bd4e31cd5fb5643dfe862c9a02ca9f90c8c51a6671d681d04ad47e4b53b1518d4befafefe8cadfb912f3d03051b1efbf1dfe37b56e93a741d8dfd80d576ca250bee55fab1311fc7b3255977558cdda6f7d6f875306e43a14413facdaed2f46093e0ef1e8f8a963e1632dcbeebd8e49fd16b57d49b08f9762de89157c65233f60c8e38a1f503a48c555f8ec45dedecd574a37601323c27be597b956343107f8bd80f3a925afaf30811df83c402116bb9c1e5231c70fff899a7c82f73c902ba54da53cc459b7bf1113db65cc8f6914d3618560ea69abd13658fa7b6af92d374d6eca9529f8bd565166e4fcbf2a8dfb3c9b69539d4d2ee2e9321b85b331925df195915f2757637c2805e1d4131e1ad9ef9bc1bb1c732d8dba4738716d351ab30c996c8657bab39567ee3b29c6d054b711495c0d52e1cd5d8e55b4f0f0325b97369280755b46a02afd54be4ddd9f77c22272b8bbb17ff5118fedbae2564524e797bd28b5f74f7079d532ccc059807989f94d267f47e724b3f1ecfe00ec9e6541c961080d8891251b84b4480bc292f6a180bea089fef5bbda56e1e41390d7c0e85ba0ef530f7177413481a226465a36ef6afe1e2bca69d2078712b3912bba1a99b1fbff0d355d6ffe726d2bb6fbc103c4ac5756e5bee6e47e17424ebcbf1b63d8cb90ce2e40198b4f4198689daea254307e52a25562f4c1455340f0ffeb10f9d8e914775e37d0edca019fb1b9c6ef81255ed86bc51c5391e0591480f66e2d88c5f4fd7277697968656a9b113ab97f874fdd5f2465e5559533e01ba13ef4a8f7a21d02c30c8ded68e8c54603ab9c8084ef6d9eb4e92c75b078539e2ae786ebab6dab73a09e0aa9ac575bcefb29e930ae656e58bcb513f7e3c17e079dce4f05b5dbc18c2a872b22509740ebe6a3903e00ad1abc55076441862643f93606e3dc35e8d9f2caef3ee6be14d513b2e062b21d0061de3bd56881713a1a5c17f5ace05e1ec09da53f99442df175a49bd154aa96e4949decd52fed79ccf7ccbce32941419c314e374e4a396ac553e17b5340336a1a25c22f9e42a243ba5404450b650acfc826a6e432971ace776e15719515e1634ceb9a4a35061b668c74998d3dfb5827f6238ec015377e6f9c94f38108768cf6e5c8b132e0303fb5a200368f845ad9d46343035a6ff94031df8d8309415bb3f6cd5ede9c135fdabcc030599858d803c0f85be7661c88984d88faa3d26fb0e9aac0056a53f1b5d0baed713c853c4a2726869a0a124a8a5bbc0fc0ef80c8ae4cb53636aa02503b86a1eb9836fcc259823e2692d921d88e1ffc1e6cb2bde43939ceb3f32a611686f539f8f7c9f0bf00381f743607d40960f06d347d1cd8ac8a51969c25e37150efdf7aa4c2037a2fd0516fb444525ab157a0ed0a7412b2fa69b217fe397263153782c0f64351fbdf2678fa0dc8569912dcd8e3ccad38f34f23bbbce14c6a26ac24911b308b82c7e43062d180baeac4ba7153858365c72c63dcf5f6a5b08070b730adb017aeae925b7d0439979e2679f45ed2f25a7edcfd2fb77a8794630285ccb0a071f5cce410b46dbf9750b0354aae8b65574501cc69efb5b6a43444074fee116641bb29da56c2b4a7f456991fc92b2"));
             scriptPubKeyBytes.write(ScriptOpCodes.OP_CHECKSIG);
             t.addOutput(new TransactionOutput(params, t, COIN.multiply(0), scriptPubKeyBytes.toByteArray()));
         } catch (Exception e) {
             // Cannot happen.
             throw new RuntimeException(e);
         }
         genesisBlock.addTransaction(t);
         genesisBlock.setTime(1231006505L);
         genesisBlock.setDifficultyTarget(1L);
         genesisBlock.setNonce(0x000000000000000000000000000000000000000000000000000000000000000bL);
         return genesisBlock;
     }

     private static KomodoMainNetParams instance;
     public static synchronized KomodoMainNetParams get() {
         if (instance == null) {
             instance = new KomodoMainNetParams();
         }
         return instance;
     }

     @Override
     public String getPaymentProtocolId() {
         return PAYMENT_PROTOCOL_ID_MAINNET;
     }
 }
