fn isDivisible(num : int) -> bool {
	for i in range(11, 21) {
		if num % i != 0 {
			return false;
		}
	}
	true
}

fn main() {
	let mut n = 1;
	loop {
		if isDivisible(n) {
			println!("{}", n);
			break;
		}
		n += 1;
	}	
}
