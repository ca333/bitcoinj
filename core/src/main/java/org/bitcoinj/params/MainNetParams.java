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
         checkpoints.put(5000, Sha256Hash.wrap("0x049cfc91eef411e96603a42c9a77c5e30e9fe96f783ab818f4c00fb56fb29b6c"));
         checkpoints.put(10000, Sha256Hash.wrap("0x0a0169db3614311cd4181deb73cfcf7f640e7dc956cda34e0121a0351925e9ae"));
         checkpoints.put(15000, Sha256Hash.wrap("0x00f0bd236790e903321a2d22f85bd6bf8a505f6ef4eddb20458a65d37e14d142"));
         checkpoints.put(20000, Sha256Hash.wrap("0x01bbf0c38892bdcced62b538329cf63bc7badca3e7e1bff8eb10345436871c6e"));
         checkpoints.put(25000, Sha256Hash.wrap("0x04ca27808268dda8f942b647a6df844be1b263a661a13740293db962022d1f9e"));
         checkpoints.put(30000, Sha256Hash.wrap("0x04c9e8cfbcd37399085e529b50147de8afb80c76c48752c122d56f23316a7acb"));
         checkpoints.put(35000, Sha256Hash.wrap("0x00815f1240354cff7487c67f7dff78e248cb9053ed2c92751d1a9ad42d3eaedf"));
         checkpoints.put(40000, Sha256Hash.wrap("0x00eafd9dfb1e5f1bf1cca0c49be628538900daf69b665464443d29c2c3b6a2fe"));
         checkpoints.put(45000, Sha256Hash.wrap("0x0377730632caf694b92f40d03ae0fbe5bd86a1205014b71d975453ac793b0af9"));
         checkpoints.put(50000, Sha256Hash.wrap("0x00076e16d3fa5194da559c17cf9cf285e21d1f13154ae4f7c7b87919549345aa"));
         checkpoints.put(55000, Sha256Hash.wrap("0x0005a0701a83e05b639418ea4c87018544a4d22b2b49e5f111161e8ffc455108"));
         checkpoints.put(60000, Sha256Hash.wrap("0x0000296fc15f8599b7c6561d0e0a96f24766135ed79107b603d6dd6e55142c0d"));
         checkpoints.put(65000, Sha256Hash.wrap("0x000861f5d7970d5399733b4605074d47f877d6536f74ffae6f08e871ee29e6f2"));
         checkpoints.put(70000, Sha256Hash.wrap("0x0002af1d487c567526c517b52996944dca344e139cddca77c2e72f746e73b263"));
         checkpoints.put(75000, Sha256Hash.wrap("0x0d08129659be5f105e70c047769359eaf3475d61a726750859fdca3e1a2bf5cc"));
         checkpoints.put(80000, Sha256Hash.wrap("0x0af5f3f1caae4f08c74a82689731d1ef8e55107c06f9a996e251b8ecb96989ad"));
         checkpoints.put(85000, Sha256Hash.wrap("0x00000c8ee29086c5fb39eddad0619773b9ce936c77c13e5e5118a4998e939544"));
         checkpoints.put(90000, Sha256Hash.wrap("0x06d3bb7f9ee5b55f67b2dc13c680699a2f736f43a44b4e4cfd41a58aa00f063f"));
         checkpoints.put(95000, Sha256Hash.wrap("0x0670981b269879aae83a88f6f0c4db34763c93fd410d96435f2acb4e6580b976"));
         checkpoints.put(100000, Sha256Hash.wrap("0x0f02eb1f3a4b89df9909fec81a4bd7d023e32e24e1f5262d9fc2cc36a715be6f"));
         checkpoints.put(105000, Sha256Hash.wrap("0x018b97d7e6d259add24afe0e08fc125dc21d734e8831b68b430f5c3896deb4af"));
         checkpoints.put(110000, Sha256Hash.wrap("0x09644ff52734e0e911a9ba7ecd03cf7995b25301840a9637891ef9af69f59c32"));
         checkpoints.put(115000, Sha256Hash.wrap("0x0ee382b4729b8ceb918a92913f9c144a6a4f8a50bfc0f8b4aac5b12592caed7f"));
         checkpoints.put(120000, Sha256Hash.wrap("0x082a7918a0dd9cb2df65f55acb8d0a4a535b3fa684d92c3ebcb24ed7019d975b"));
         checkpoints.put(125000, Sha256Hash.wrap("0x00008f76c4484fd539c9d02fc69c40a50b6f9e00984d33890b85cc0324159e9e"));
         checkpoints.put(130000, Sha256Hash.wrap("0x011b09e53acfe46f310e8c960a9c4f4f490cc7b2cd3791d7a6a80d6e8ac96b36"));
         checkpoints.put(135000, Sha256Hash.wrap("0x01e0cd48358fa05646baa6f00e26717474d6049a537c8861b324d1f497dc3d4a"));
         checkpoints.put(140000, Sha256Hash.wrap("0x0e6db36fd8a9d1b7baf359c8bd5c76635d0bcada973a75b5d2028ca3baea4961"));
         checkpoints.put(145000, Sha256Hash.wrap("0x00010c40b57316ce6cde076807c9db956452a3c82cb09fe7d56c6bb1a7e24726"));
         checkpoints.put(150000, Sha256Hash.wrap("0x0a817f15b9da636f453a7a01835cfc534ed1a55ce7f08c566471d167678bedce"));
         checkpoints.put(155000, Sha256Hash.wrap("0x0528084fd00223bd9747635d7a4d8cc79f158795cad654efb78e4e4cc5f23d6a"));
         checkpoints.put(160000, Sha256Hash.wrap("0x00003a09f26ae9fb7ebbfa3ef589b81ccd8909a82430f7414bc68d5a5a3316ab"));
         checkpoints.put(165000, Sha256Hash.wrap("0x00004a0c6a29e7d1f22ea4e44d05e861fec5fcd8eebc5a61574c4ecf29dbb9be"));
         checkpoints.put(170000, Sha256Hash.wrap("0x0cf9eac27badc0ae9a2b370dd7cc3fcb550f139349551e60978f394a2e1b262b"));
         checkpoints.put(175000, Sha256Hash.wrap("0x0000137856b825d431da27ff4c3cf22f5482fa21952d45b0db0ec6774fb9b510"));
         checkpoints.put(180000, Sha256Hash.wrap("0x000000b0afcccf98aa0afb6ac61050892bd9415857d66313d1f67fd1bbac312f"));
         checkpoints.put(185000, Sha256Hash.wrap("0x00c2af8f88d84de080067f8ae1c25754e32e5516d20c11f85b9adae2d683687b"));
         checkpoints.put(190000, Sha256Hash.wrap("0x00000033d85b3e7d19e02278ef300b8ab957d3dd3e58b4c81166ba0a58af5c3f"));
         checkpoints.put(195000, Sha256Hash.wrap("0x000000964b6068be1dd4ee6893d183e86cba82a2744fb5439c463d0ba7e053b6"));
         checkpoints.put(200000, Sha256Hash.wrap("0x000001763a9337328651ca57ac487cc0507087be5838fb74ca4165ff19f0e84f"));
         checkpoints.put(205000, Sha256Hash.wrap("0x049fc6832e64a75ae898b32804e151e7561ea49082858c3d4af89a7de4b82f06"));
         checkpoints.put(210000, Sha256Hash.wrap("0x0000000d9078b9c9604cc663eafafba8f3643bb3f3ddbb78fed4993236e1edb5"));
         checkpoints.put(215000, Sha256Hash.wrap("0x00060089ecc21bcc62094e2f7f0448fe163415f6ef2f2aafe047757889ca82fe"));
         checkpoints.put(220000, Sha256Hash.wrap("0x000082c78e6c2a13a9c23dd7a6faaf962fc133142b4a2d07725561f59c03bfa2"));
         checkpoints.put(225000, Sha256Hash.wrap("0x00030026483167fe13505cf27049307ce42e0d9c5aa093aed10baa4f49edf4ca"));
         checkpoints.put(230000, Sha256Hash.wrap("0x000183a3e17988060a35776b99c1f0b43393bbe7153b2718dfc57f428191de4e"));
         checkpoints.put(235000, Sha256Hash.wrap("0x000184995f0ec024ed3783e322c8cfa5e68d9f0c77c3aaea301b22d311619156"));
         checkpoints.put(240000, Sha256Hash.wrap("0x0000002cc7cf6d0a44ab57f9bd3bfa11a865bbf1cd87a2081095bc90981633a3"));
         checkpoints.put(245000, Sha256Hash.wrap("0x004c5f19a88c8fe8a604006dbd2d44c94baef2a00876a17d8e2be2124003f979"));
         checkpoints.put(250000, Sha256Hash.wrap("0x0dd54ef5f816c7fde9d2b1c8c1a26412b3c761cc5dd3901fa5c4cd1900892fba"));
         checkpoints.put(255000, Sha256Hash.wrap("0x0b6da9e4f50c8bc7a92c539bc7474ffd6c29e0a8531f0dbbbc261fff1f990827"));
         checkpoints.put(260000, Sha256Hash.wrap("0x0cac8b12bf7233ee5a68fcde9e251852b177833fefa2a9f39ec28474b0851cb9"));
         checkpoints.put(265000, Sha256Hash.wrap("0x04feb5b4029f3b8b8eb3e6661a78eadd1a26b4af00ac59b5f05b261afcfd2818"));
         checkpoints.put(270000, Sha256Hash.wrap("0x01bc5897bd20b8b61acf4989987ba85fbc37d9ebe848924aa8effcb08bf48fe0"));
         checkpoints.put(275000, Sha256Hash.wrap("0x0416bc29eb5a12231826e546ba90fcd38aeef387ff77b45849cd418a9c1a6f12"));
         checkpoints.put(280000, Sha256Hash.wrap("0x000007593e9880b171d46bce59aa0cec2a1b1f53d1fd7e8f71ccb2b9182374a4"));
         checkpoints.put(285000, Sha256Hash.wrap("0x05a338b2d90cd79740221fe8635b7a834f2e486fcbb2464a4294f5a21231a5f5"));
         checkpoints.put(290000, Sha256Hash.wrap("0x064ca3912cdcd833702d07a530e98bc5c6c1cd738a8825c7240b17cd68ca0cc4"));
         checkpoints.put(295000, Sha256Hash.wrap("0x036b3bb318d743fd78db983a9aadd52869991d48913c4eebe2a074387d67cc5a"));
         checkpoints.put(300000, Sha256Hash.wrap("0x000000fa5efd1998959926047727519ed7de06dcf9f2cd92a4f71e907e1312dc"));
         checkpoints.put(305000, Sha256Hash.wrap("0x00003656231e83de2348755153ed175794696a113d7e8a15c01f90fdb7c2f287"));
         checkpoints.put(310000, Sha256Hash.wrap("0x0cf6baf727eb931da0813ed8b032648c4766be79e146b0d40c643f9d8edf40f7"));
         checkpoints.put(315000, Sha256Hash.wrap("0x082469974c152ebe69f1787f0d06aa5d9dd1dc69c880febde7eac2bc800146dd"));
         checkpoints.put(320000, Sha256Hash.wrap("0x0000063df36b99bfb2516f55cb548a5baed1f2d8ae69c3559dc478c5c2eb32df"));
         checkpoints.put(325000, Sha256Hash.wrap("0x0cb926b303a1514ba0a2f729af88ccb143517f396e9e0bde09b0736900698e0f"));
         checkpoints.put(330000, Sha256Hash.wrap("0x000000be3d8bb6e31c3b534819aae7014cbbe9a44ab3e799dc1bfc724c6ab184"));
         checkpoints.put(335000, Sha256Hash.wrap("0x0d0756608189fd5bbd8ec50e76180074e69e973439cc09df49134e4cb970ed4d"));
         checkpoints.put(340000, Sha256Hash.wrap("0x0d814eacdb9c97003d703c0ff79b1b97b9ed8615fe12b1afaede946e5fdfe0a7"));
         checkpoints.put(345000, Sha256Hash.wrap("0x000000c2910f510f1de325d300202da1a391f2719dd378173299151c3da94e85"));
         checkpoints.put(350000, Sha256Hash.wrap("0x0000000228ef321323f81dae00c98d7960fc7486fb2d881007fee60d1e34653f"));
         checkpoints.put(355000, Sha256Hash.wrap("0x03e6a55e382b478e0fab9c3584da3629fd9b977986a333a406b24b0d3559bf44"));
         checkpoints.put(360000, Sha256Hash.wrap("0x0859c86dd718bcb5b58af06389197794e2beea6239653f2e6fa7b8a7433d29ea"));
         checkpoints.put(365000, Sha256Hash.wrap("0x07896332665c707a8f55398a998e7878e8d2681ba79dd95c2859b1dafc9343d0"));
         checkpoints.put(370000, Sha256Hash.wrap("0x040efd8c64cf5cf96ecf75468741a8880d1386eb5e349bef0a55116d4023944c"));
         checkpoints.put(375000, Sha256Hash.wrap("0x053029e7599a09fe6c01203997d7ca738dd4c6d216a433695a0d514def1eccc0"));
         checkpoints.put(380000, Sha256Hash.wrap("0x0cae44e7a421c389b88a5a204d3e39779e93aeacaab1b693741bf279fd0c8acd"));
         checkpoints.put(385000, Sha256Hash.wrap("0x0b4032d2c799ba93644231ce57134dd24e13ec0dc267c1ed5912389691d2bd72"));
         checkpoints.put(390000, Sha256Hash.wrap("0x0afd0f166f33a881ef289af7ea7010d58c4bbd560dee10b561c79e1b8dfd0593"));
         checkpoints.put(395000, Sha256Hash.wrap("0x083774b88cf1b138d67c242d9b33c54f69d7e901b5e8144dc4a2303ab9927102"));
         checkpoints.put(400000, Sha256Hash.wrap("0x036d294c5be96f4c0efb28e652eb3968231e87204a823991a85c5fdab3c43ae6"));
         checkpoints.put(405000, Sha256Hash.wrap("0x0522e33bb2161fb1b33acef9a4a438fcf420dcae8a0b472e234d223d731c42b2"));
         checkpoints.put(410000, Sha256Hash.wrap("0x0361d06aa807c66b87befea8119a485341d1118b694c3dbb4c3cf0b85ac69e9b"));
         checkpoints.put(415000, Sha256Hash.wrap("0x072d5653d8673f64ef8b9c655f7b8021072070a072b799013ff6e96de99a59e6"));
         checkpoints.put(420000, Sha256Hash.wrap("0x013b693d66955be69d4501cb1d307ca323a5c8473e25866ae7e700cdce0c654f"));
         checkpoints.put(425000, Sha256Hash.wrap("0x0ef0c55af27c6971289a790dee2b2ec728fb9c6555ff9306c07f1083cf0fb4b5"));
         checkpoints.put(430000, Sha256Hash.wrap("0x0ccbeeaba28291e0316a9cf54c005097c61dc67ba6f32283406d6c83b828da00"));
         checkpoints.put(435000, Sha256Hash.wrap("0x020ed6b7fe1124400baba7feed463ba0c90e7e6903493fdc1a1a18c4a506055a"));
         checkpoints.put(440000, Sha256Hash.wrap("0x055aaadca1908abeedc831a3f9115aa31284fc223d010590caf7b612960b61a4"));
         checkpoints.put(445000, Sha256Hash.wrap("0x06d2327fa25ea7e2be742fc0e45fc4f9adb41811f21be0357f8543c5434df715"));
         checkpoints.put(450000, Sha256Hash.wrap("0x0906ef1e8dc194f1f03bd4ce1ac8c6992fd721ef2c5ccbf4871ec8cdbb456c18"));
         checkpoints.put(455000, Sha256Hash.wrap("0x0b8b92eec29eb20262dcf9916f0ca36d6abf0c39d321d3f480a5535cb978db71"));
         checkpoints.put(460000, Sha256Hash.wrap("0x0cb04591f69a255b1127aaff3bbd59eaa21a5d9cca999de197516c251895c536"));
         checkpoints.put(465000, Sha256Hash.wrap("0x029985ae78d8bb8fd170aeb3ab02ea76134ed0c19ae00211cc28a61fe5755b88"));
         checkpoints.put(470000, Sha256Hash.wrap("0x01a2f4b56f37b223e75572862ad1ba956ec179332f8cd40590d7253563c86ba8"));
         checkpoints.put(475000, Sha256Hash.wrap("0x0a34c6f9d4d9cb8c78c14b8041a7cc1874cfcbb22a34a5c068d1d6ff3ed9fdf0"));
         checkpoints.put(480000, Sha256Hash.wrap("0x0ebab25030179996ae25969f34f6a297c7ffce1994f9b4186082a47032a9a7dc"));
         checkpoints.put(485000, Sha256Hash.wrap("0x06a096e6bccf3b85537a30f95db6a414deacc0509bc84da264c2830df1a1d9b0"));
         checkpoints.put(490000, Sha256Hash.wrap("0x0af828930ef13405cb536b88a3d1d4e0d84dc79ee260402c56bfa86e261c74ff"));
         checkpoints.put(495000, Sha256Hash.wrap("0x09d44905bfd12849d3c2178b2ba882f8e9d6565b6e4d7a97c70a92bd6de7c5e6"));
         checkpoints.put(500000, Sha256Hash.wrap("0x0bebdb417f7a51fe0c36fcf94e2ed29895a9a862eaa61601272866a7ecd6391b"));
         checkpoints.put(505000, Sha256Hash.wrap("0x0c1609f4f3561baa1fc975877948af94d2107c88686a9821bc240016cc87d953"));
         checkpoints.put(510000, Sha256Hash.wrap("0x0cf9a5a4997b871e615e5e398627e45fa15b3e6970ae22b47bdd11b0f5fa0fa7"));
         checkpoints.put(515000, Sha256Hash.wrap("0x034171d4819e9961de13309743a32a179abede97d60ea64101dc04c97a1a0807"));
         checkpoints.put(520000, Sha256Hash.wrap("0x0648fa44d5bbc2cc04a782e083c11df64ac06185f0f8e11a7416625ebb6409a6"));
         checkpoints.put(525000, Sha256Hash.wrap("0x0000000ef17d63af3159e52cd351b6f000536ad88adc3a937bb747955fed58a2"));
         checkpoints.put(530000, Sha256Hash.wrap("0x08e3af153995ba09e50086b64145cf4cd57db6b29f16f06f28d80d7f6121cfad"));
         checkpoints.put(535000, Sha256Hash.wrap("0x02a0ffd00b51e2061b85de50a9223d9c84f4e357dc1046397bb9d7d4a827a3fb"));
         checkpoints.put(540000, Sha256Hash.wrap("0x04bf07d026af29025c1ac2815e067f4a41d2872701ac9780eb3015d51cdcd854"));
         checkpoints.put(545000, Sha256Hash.wrap("0x0a0d6d86635946792ad0dca57ed227a5360fc8b6d79e47132aac11e90a4963ce"));
         checkpoints.put(550000, Sha256Hash.wrap("0x06df52fc5f9ba03ccc3a7673b01ab47990bd5c4947f6e1bc0ba14d21cd5bcccd"));
         checkpoints.put(555000, Sha256Hash.wrap("0x0baf38eea8e08fcad3a9d760f27377e79c291b08e7fb4920cadd5cb7bab547f3"));
         checkpoints.put(560000, Sha256Hash.wrap("0x00000004c34abbf1366adbae965b644c01debf15409acc715ff51cb221d92dd7"));
         checkpoints.put(565000, Sha256Hash.wrap("0x067bae7119f083e0fa1820bc8e25dcfa7717e42aabaef18beefd87d974953dfb"));
         checkpoints.put(570000, Sha256Hash.wrap("0x00000011a7ce7b628b7be17777d8dea2574d83f165e23c9e44aa705975820fd3"));
         checkpoints.put(575000, Sha256Hash.wrap("0x0e1110a193a30d3f8d369017233a2486b11c748b3d033859a2eb7b37062d303e"));
         checkpoints.put(580000, Sha256Hash.wrap("0x083cb58484aff80f48e3537e0451d49e544b3efa3da97274800c91e567d33a92"));
         checkpoints.put(585000, Sha256Hash.wrap("0x0224cf835428d03472edf4f7b6fcc63b9d8d6f1d5a90ad8186bf123d541b4ea8"));
         checkpoints.put(590000, Sha256Hash.wrap("0x0cfcf3b9517894e4df49db5faf8b74f3a9e01eb83c0cc5051c115d4424615dae"));
         checkpoints.put(595000, Sha256Hash.wrap("0x0000000a45266983dd81e0df381a3b0455699b2f76d5b4d3f17b87d657a1b56d"));
         checkpoints.put(600000, Sha256Hash.wrap("0x00000005080d5689c3b4466e551cd1986e5d2024a62a79b1335afe12c42779e4"));
         checkpoints.put(605000, Sha256Hash.wrap("0x0000001c691da36848542299af859d4eb3fa408a0f425b1fbe6d622d2100623a"));
         checkpoints.put(610000, Sha256Hash.wrap("0x040d8c7a0ac89e3ed8605a198583a795986aacbf18722a9897d7b925bcf757f6"));
         checkpoints.put(615000, Sha256Hash.wrap("0x0449cf00fc36206389c14cbf1d762f8b96bb0440ccea5b46703e7c69b0e2bc42"));
         checkpoints.put(620000, Sha256Hash.wrap("0x07227a41340c25ee1a7e9b60414259780202ffa990079fc91d8faeac9af03e60"));
         checkpoints.put(625000, Sha256Hash.wrap("0x047c2472fe2afabb3d38decf24bba4ba712b60e7a1782f4afae3ede3f912f493"));
         checkpoints.put(630000, Sha256Hash.wrap("0x0a7f1f04e66260cf972ab1374a9126b8abc1adaa3ab4669db5d4d4ddb9ad493d"));
         checkpoints.put(635000, Sha256Hash.wrap("0x048df95165eb821dabf37ef28cf7f3be72e216e95377684253dab806985b50a4"));
         checkpoints.put(640000, Sha256Hash.wrap("0x066b3c6a6a3c8dc58bef509a972c3e3ade14493b40e1b361ecbc928134e302be"));
         checkpoints.put(645000, Sha256Hash.wrap("0x07d059888c9ade3bbe16d6b4d70ee9b8302d104b37a3c6cd61f81012aabd0e1e"));
         checkpoints.put(650000, Sha256Hash.wrap("0x039a3cb760cc6e564974caf69e8ae621c14567f3a36e4991f77fd869294b1d52"));
         checkpoints.put(655000, Sha256Hash.wrap("0x089350ee8d28b44837eb4b1fe77704953d5de2077f10c74a888d9d3ea1e13c2a"));
         checkpoints.put(660000, Sha256Hash.wrap("0x000000023f8a582a61ae2f6fab6fe8197e79b7a68aaac67432421b09f1bdd4ba"));
         checkpoints.put(665000, Sha256Hash.wrap("0x0b16edce865e7a0d662115774e0c0d3abbf9c69004155b693ddc933f051bfb26"));
         checkpoints.put(670000, Sha256Hash.wrap("0x09070b109b089490bc372fd8358abae352d6db0e46ade6ed2200e4d4ff7aa6af"));
         checkpoints.put(675000, Sha256Hash.wrap("0x08d9edeed3b6ac55991e9f32af0218ff8fa9dc808078623f4c831eb09d4f186b"));
         checkpoints.put(680000, Sha256Hash.wrap("0x00000003eb2b30bfac929d3496acecab19625ac9f854a86aaf9678bea99e1cc1"));
         checkpoints.put(681777, Sha256Hash.wrap("0x0000243296b9b26c040f471fdd9398ef72e57062cf05c19b9ba2fefac8165306"));
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
