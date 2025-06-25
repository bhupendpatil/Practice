
# THIS IS AN ANVIL GLOBALLY KNOWN PRIVATE KEY!!
setup-anvil:
	forge script script/SetupAnvil.s.sol --rpc-url http://127.0.0.1:8545 --private-key ${ANVIL_KEY} --via-ir --broadcast -vvv

anvil: 
	anvil --dump-state marketplace-anvil.json

mint-usdc:
	forge script script/MintUSDC.s.sol --rpc-url http://127.0.0.1:8545 --private-key ${ANVIL_KEY} --via-ir --broadcast -vvv