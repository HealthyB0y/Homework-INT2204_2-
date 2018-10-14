package Dictionary;

import java.io.Serializable;

public class Word {
	private String wordTarget;
	private String wordExplain;

	public Word(String wordTarget, String wordExplain) {
		super();
		this.wordTarget = wordTarget;
		this.wordExplain = wordExplain;
	}

	public Word(String wordTarget) { 
		super();
		this.wordTarget = wordTarget;
	}

	public Word() {
		super();
	}

	public String getWordTarget() {
		return wordTarget;
	}

	public void setWordTarget(String wordTarget) {
		this.wordTarget = wordTarget;
	}

	public String getWordExplain() {
		return wordExplain;
	}

	public void setWordExplain(String wordExplain) {
		this.wordExplain = wordExplain;
	}
	//phương thức kiểm tra trùng khớp ở lớp management thực hiện thêm,sửa,xóa
	@Override
	public boolean equals(Object obj) {
//		System.out.println("print");
		return this.wordTarget.equals(((Word) obj).getWordTarget());
	}
	@Override
	public String toString() {
		return wordTarget + "=" + wordExplain;
	}

}
