package spock

import spock.lang.Specification

class Publisher {
  List<Subscriber> subscribers = []

  def send(event) {
    subscribers.each {
      try {
        it.receive(event)
      } catch (Exception e) {}
    }
  }
}

class Subscriber {
  String receive(String event) {
    return event;
  }
}

class PublisherSpec extends Specification {
  def pub = new Publisher()
  def sub1 = Mock(Subscriber)
  def sub2 = Mock(Subscriber)

  def setup() {
    pub.subscribers << sub1 << sub2
  }

  def "delivers events to all subscribers"() {
    when:
    pub.send("event")

    then:
    1 * sub1.receive("event")
    1 * sub2.receive("event")
  }


  def "stubbing test"() {
    setup:
    sub1.receive(_) >> "ok"

    when:
    pub.send("event")

    then:
    sub1.receive("event") == "ok"
  }

}
