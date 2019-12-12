import javax.swing.JOptionPane;

public class Calculator {

	private double sayi1, sayi2;
	private boolean kosul = true;
	private char secenek  ;
	private double sonuc;
	private String equal;

	public char getSecenek() {
		return secenek;
	}

	public void setSecenek(char secenek) {
		this.secenek = secenek;
	}

	public double getSayi1() {
		return sayi1;
	}

	public void setSayi1(double sayi1) {
		this.sayi1 = sayi1;
	}

	public double getSayi2() {
		return sayi2;
	}

	public void setSayi2(double sayi2) {
		this.sayi2 = sayi2;
	}

	public double getSonuc() {
		return sonuc;
	}

	public void setSonuc(double sonuc) {
		this.sonuc = sonuc;
	}

	public boolean getKosul() {
		return kosul;
	}

	public void setKosul(boolean sayac) {
		this.kosul = sayac;
	}
	
	public String getDeletedText(double sayi) {
		String resText =getFormattedText(sayi);
		int sizeNum = resText.length();
		resText = resText.substring(0, sizeNum-1);

		
		return resText ;
	}
	
	public String getMinusFormattedText(double sayi) {
		String resText = getFormattedText(sayi);
		String str = "-";
		if(resText.startsWith(str)) {
			return resText;
			
		}
		resText = "-"+resText;
		return resText;
	}
	public String getDotFormattedText(double sayi) {
		String resText = getFormattedText(sayi);
		String str = ".";
		if(resText.contains(str)) {
			return resText;
			
		}
		resText =resText+".";
		return resText;
	}

	public String getFormattedText(double temp) {

		String resText = "" + temp;
		int fromNum = resText.indexOf(".0");
		int charNum = resText.length() - fromNum;
		if (charNum > 2) {
			return resText;
		} 
		else if (resText.lastIndexOf(".0") > 0)
			resText = resText.substring(0, resText.length() - 2);

		return resText;
	}

	public String equal() {
		switch (secenek) {
		case '+':

			sonuc = sayi1 + sayi2;
			equal = getFormattedText(sonuc);
			break;

		case '-':
			sonuc = sayi1 - sayi2;
			equal = getFormattedText(sonuc);
			break;
		case '*':
			sonuc = sayi1 * sayi2;
			equal = getFormattedText(sonuc);
			break;
		case '/':
			try {
				sonuc = sayi1 / sayi2;
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "Bölümü 0 girdiniz");
			}
			equal = getFormattedText(sonuc);
			break;
		case 'x':
			equal = getFormattedText(sayi1);
			break;
		case '%':
			sonuc = sayi1 / 100;
			equal = getFormattedText(sonuc);
		case '#':
			sonuc = 1/sayi1 ;
			equal = getFormattedText(sonuc);
			
		}
		
		return equal;

	}
}