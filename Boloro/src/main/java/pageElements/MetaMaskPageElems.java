package pageElements;

	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.support.FindBy;
	import org.openqa.selenium.support.PageFactory;


	public class MetaMaskPageElems {
			WebDriver PageElemsdriver;
			public  MetaMaskPageElems(WebDriver driver) {
				PageFactory.initElements( driver, this);
				PageElemsdriver=driver;
				
			}
			
			@FindBy(xpath="//button[@tabindex=\"0\"]")
			public WebElement GetStartedBtn;
			
			@FindBy(xpath="//button[contains(text(),\"Import wallet\")]")
			public WebElement ImportWalletBtn;
			
			@FindBy(xpath="//button[contains(text(),\"I Agree\")]")
			public WebElement IAgreeBtn;
			
			@FindBy(xpath="//input[@placeholder=\"Paste Secret Recovery Phrase from clipboard\"]")
			public WebElement SecretRecoveryPhraseFromClipboard;
			
			@FindBy(xpath="//input[@id=\"password\"]")
			public WebElement PasswordField;
			
			@FindBy(xpath="//input[@id=\"confirm-password\"]")
			public WebElement ConfirmPasswordFld;
			
			@FindBy(xpath="//div[7]/div[@role=\"checkbox\"]")
			public WebElement TermsAndCondCheckBox;
			
			@FindBy(xpath="//button[@type=\"submit\"]")
			public WebElement ImportBtn;
			
			@FindBy(xpath="//button[@role=\"button\"]")
			public WebElement AllDoneBtn;
			
			@FindBy(xpath="//button[@title=\"Close\"]")
			public WebElement PopUpClose;
			
			@FindBy(xpath="//div[@class=\"identicon\"]")
			public WebElement AccntProfileBtn;
			
			@FindBy(xpath="//div[contains(text(),\"Settings\")]")
			public WebElement SettingsOptn;
			
			@FindBy(xpath="//div[contains(text(),\"Create Account\")]")
			public WebElement CreateAcntOptn;
			
			@FindBy(xpath="//input[@class=\"new-account-create-form__input\"]")
			public WebElement AccntNameFld;
			
			@FindBy(xpath="//button[contains(text(),\"Create\")]")
			public WebElement CreateBtn;
			
			@FindBy(xpath="//div[@class=\"selected-account__address\"]")
			public WebElement WalletAddress;
			
			@FindBy(xpath="//button[@title=\"Account Options\"]")
			public WebElement ThreeDot;
			
			@FindBy(xpath="//span[contains(text(),\"Account details\")]")
			public WebElement AccountDetails;
			
			@FindBy(xpath="//button[contains(text(),\"Export Private Key\")]")
			public WebElement ExportPrivateKey;
			
			@FindBy(xpath="//input[@type=\"password\"]")
			public WebElement PrivateKeyPasswordFld;
			
			@FindBy(xpath="//button[contains(text(),\"Confirm\")]")
			public WebElement PrivateKeyConfirmBtn;
			
			@FindBy(xpath="//textarea[@class=\"readonly-input__input export-private-key-modal__password-display-textarea\"]")
			public WebElement PrivateKey;
			
			@FindBy(xpath="//button[contains(text(),\"Done\")]")
			public WebElement PrivateKeyDoneBtn;
			
			@FindBy(xpath="//button[contains(text(),\"Next\")]")
			public WebElement PopUpNextBtn;
			
			@FindBy(xpath="//button[contains(text(),\"Connect\")]")
			public WebElement PopUpConnectBtn;
			
			@FindBy(xpath="//button[contains(text(),\"Sign\")]")
			public WebElement PopUpSignBtn;
			
			@FindBy(xpath="//div[@class=\"chip__right-icon\"]")
			public WebElement NetWorkDrpDwn;
			
			@FindBy(xpath="//span[contains(text(),\"Ropsten Test Network\")]")
			public WebElement RopstenTestNetworkOptn;
			
			@FindBy(xpath="//button[@data-testid=\"eth-overview-send\"]")
			public WebElement SendBtn;
			
			@FindBy(xpath="//input[@data-testid=\"ens-input\"]")
			public WebElement AddressInputFld;
			
			@FindBy(xpath="//input[@type=\"number\"]")
			public WebElement AmountInputFld;
			
			@FindBy(xpath="//button[@data-testid=\"page-container-footer-next\"]")
			public WebElement PaymentNxtBtn;
			
			@FindBy(xpath="//button[@data-testid=\"page-container-footer-next\"]")
			public WebElement PaymentCnfmBtn;
			
			@FindBy(xpath="//div[contains(text(),\"Pending\")]")
			public WebElement PaymentPendingStatus;
			
			@FindBy(xpath="//button[@data-testid=\"popover-close\"]")
			public WebElement PopUpCloseBtn;
			
			@FindBy(xpath="//div[contains(text(),\"Networks\")]")
			public WebElement NetWorksOptn;
			
			@FindBy(xpath="//button[@role=\"button\"]")
			public WebElement AddNetworkBtn;
			
			@FindBy(xpath="//input[@id=\"network-name\"]")
			public WebElement NetworkNameFld;
			
			@FindBy(xpath="//input[@id=\"rpc-url\"]")
			public WebElement NewRPCURLFld;
			
			@FindBy(xpath="//input[@id=\"chainId\"]")
			public WebElement ChainID;
			
			@FindBy(xpath="//input[@id=\"network-ticker\"]")
			public WebElement CurrencySymbolFld;
			
			@FindBy(xpath="//input[@id=\"block-explorer-url\"]")
			public WebElement BlockExplorerURLFld;
			
			@FindBy(xpath="//button[contains(text(),\"Save\")]")
			public WebElement SaveNetworkBtn;
			
			@FindBy(xpath="//button[@data-testid=\"page-container-footer-next\"]")
			public WebElement BidConfirmBtnInMetaMask;
		}
	

