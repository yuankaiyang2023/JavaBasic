package 基础知识;

public class GenerateEquals {
int n;
static int m;
String s;
@Override
public int hashCode() {//提供一个散列码
	final int prime = 31;
	int result = 1;
	result = prime * result + n;
	result = prime * result + ((s == null) ? 0 : s.hashCode());
	return result;
}
@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	GenerateEquals other = (GenerateEquals) obj;
	if (n != other.n)
		return false;
	if (s == null) {
		if (other.s != null)
			return false;
	} else if (!s.equals(other.s))
		return false;
	return true;
}
public static void main(String[] args) {
	GenerateEquals g = new GenerateEquals();
	System.out.println(g.hashCode());
}
}
