function counter(i) {
  setTimeout(() => {
    console.log(i);
    if (i < 5) counter(i + 1);
  }, 1000)
}
counter(1);