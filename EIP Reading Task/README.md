### Reading task EIP

Find at least 10 terms and make a glossery




* Channels (p.57)  
Is a pipe to connect a sender to a receiver. This is where a message is transmitted.

* Messages (p.57)  
This is the actual message, that is sendt.

* Pipes & filters (p.58)  
The Pipes and Filters architecture describes how multiple processing steps can be
chained together using channels

* Router (p.58)  
The route a message must follow may be so complex
that the original sender does not know what channel will get the message to
the final receiver. Instead, the original sender sends the message to a Message
Router. The router then determines how to navigate the channel topology and directs the message to the final receiver, or at
least to the next router

* Endpoints (p.58)  
Most applications do not have any built-in capability to interface with a messaging system. Rather, they must contain a layer of code that
knows both how the application works and how the messaging system
works, bridging the two so that they work together. This bridge code is a set
of coordinated Message Endpoints that enable the application to send
and receive messages

* Sender and receiver (p.62)  
The most generic terms are probably sender and receiver, used for the applications that use a message system

* Marshalling (p.66)
Marshaling is how a Remote Procedure Call (RPC) sends arguments to the
remote process and how the process returns the result

* Header + Body (p.67)  
1. Header—Information used by the messaging system that describes the data
being transmitted, its origin, its destination, and so on.
2. Body—The data being transmitted, which is generally ignored by the messaging system and simply transmitted as is

* Pipeline processing(p.67)  
Connecting components with asynchronous Message Channels (60) allows each
unit in the chain to operate in its own thread or its own process. When a unit
has completed processing one message, it can send the message to the output
channel and immediately start processing another message. It does not have to
wait for the subsequent components to read and process the message. This
allows multiple messages to be processed concurrently as they pass through the
individual stages. For example, after the first message has been decrypted, it can
be passed on to the authentication component. At the same time, the next message can already be decrypted (see figure). We call such a configuration a processing pipeline because messages flow through the filters like liquid flows
through a pipe

* Message router logic (p.80)  
Meaning the routing rules

* Content-based router (p.81)  
Many Message Routers decide the message destination only on properties of
the message itself—for example, the message type or the values of specific message fields. We call such a router a Content-Based Router

* Context-based router (p.82)  
Other Message Routers decide the message’s destination based on environment conditions. We call these routers context-based routers. Such routers are
commonly used to perform load-balancing, test, or failover functionality



