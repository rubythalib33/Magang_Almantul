package prototype;
import java.util.Random;

public class Prototype {
	Random rand = new Random();
	
	int k = 4;
	float[][] a = new float[23][5];
	String[] b = {"Habbatussauda Extra Propolis Trigon","Habbatussauda Oil 200 Kapsul",
			 "Habasyi Oil 100 Kps","Habasyi Oil 210 Kps","Kapsul Habbatus Sauda",
			 "Habat Oil 369","Habbatussauda Al-Afiat 100 Kps",
			 "Habbatussauda Al-Afiat 200 Kps","Habbatussauda Oil Al-Afiat 100 Kps",
			 "Habbatussauda Oil Al-Afiat 200 Kps","Habbatussauda Oil Al-Afiat 60 Kps",
			 "Propolis Brazalian / Botol","Propolis Diamond Lite 20 / Botol",
			 "Propolis Diamond Regular / Botol","Propolis Melia Nature / Botol",
			 "Propolis Melia Sehat / Botol","Propolis Prosmart/ Botol",
			 "Madu Al-Kautsar","Madu Batuk Al-Wadey","Madu for Mama Al Mabruroh",
			 "Madu Hitam Pahit 460 gram","Madu Hutan Liar Al Wadey 500 Gram",
			 "Madu Hutan Sialang 1 Kg"};
	double[][] c = {{109.,41.,54.16666667},
			 { 99.,16.,55.        },
			 { 85.,16.,50.        },
			 { 81.,18.,50.        },
			 { 81.,30.,58.33333333},
			 { 83.,49.,57.14285714},
			 {113.,32.,42.85714286},
			 {110.,20.,50.        },
			 {106.,38.,50.        },
			 { 99.,42.,54.54545455},
			 { 89.,42.,50.        },
			 { 92.,50.,52.        },
			 { 89.,36.,54.54545455},
			 {101.,37.,52.        },
			 {102.,47.,55.        },
			 { 87.,22.,50.        },
			 { 83.,41.,55.        },
			 {107.,43.,55.55555556},
			 { 87.,43.,46.15384615},
			 {100.,18.,53.84615385},
			 { 92.,42.,52.94117647},
			 {112.,49.,47.91666667},
			 {117.,18.,52.        }};
	
	void  input() {
		
	}
	double[] dist(int[] a, int[][] b) {
		double[] temp = new double[k];
		for(int i=0;i<temp.length;i++) {
			double temp2 =0;
			for(int j=0;j<3;j++) {
				temp2+=Math.pow(a[j]-b[i][j],2);
			}
			temp[i]=Math.sqrt(temp2); 
		}
		return null;
	}
	double[][] generate_centroid() {
		double[][] centroid= new double[k][3];
		for (int i=0;i < k; i++) {
			for(int j=0; j<3; j++) {
				centroid[i][j]=rand.nextInt(75)+rand.nextDouble();
			}
		}
		return centroid;
	}
	void kmeans() {
		
	}
	void cluster() {
		
	}

	public static void main(String[] args) {
		System.out.println();

	}

}
