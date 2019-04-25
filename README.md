A set of examples what to do and what not to do in order to make life easier and quality architecture at the same time.

# Factory

Examples showing how introducing one degree of freedom in a form of factory object 
makes testing simplier compared to direct constructor call.

# Processor object vs. Private method

Performing unrelated calculation directly in object's private method forces developer to test all the logic
with the object. Separating such logic in extra object splits the testing effort into smaller tasks and helps
the code to be more modular and loosely coupled.