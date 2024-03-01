const person = {
  name: "Busani",
  address: {
    line1: "123 Baker Street",
    city: "London",
    country: "UK",
  },
  profiles: ["twitter", "linkedin", "instagram"],
  printProfile: () => {
    person.profiles.map((profile) => console.log(profile));
  },
};

export default function LearningJavaScript() {
  return (
    <>
      <div>Name: {person.name}</div>
      <div>{person.address.line1}</div>
      <div>{person.address.city}</div>
      <div>{person.profiles[1]}</div>
      <div>{person.printProfile()}</div>
    </>
  );
}
