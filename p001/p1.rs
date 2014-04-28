fn divisible_by(num: int, divider: int) -> bool {
	num % divider == 0
}

fn main() {
	let mut sum = 0;
	for n in range(0, 1000) {
		if divisible_by(n, 3) || divisible_by(n, 5) {
			sum += n;
		}
	}
	println!("Sum: {}", sum);
}
