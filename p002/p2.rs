fn main() {
	let mut sum = 0;
	let mut fib = 1;
	let mut a = 1;
	let mut b = 1;
	
	while fib < 4_000_000 {
		if fib % 2 == 0 {
			sum += fib;
		}
		
		fib = a + b;
		b = a;
		a = fib;
	}
	println!("{}", sum);
}
